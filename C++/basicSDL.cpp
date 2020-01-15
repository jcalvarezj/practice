/*
 * Basic example of a program that uses the SDL library
 *
 * @author J. Alvarez
 */
#include <iostream>
#include <cstring>
#include "SDL2/SDL.h" //#include <SDL.h> for Linux

typedef const unsigned int cint;

int main(int argc, char ** args) {
	cint WIDTH = 800;
	cint HEIGHT = 600;

	if(SDL_Init(SDL_INIT_VIDEO) < 0) {
		std::cout << "Could not initialize SDL graphics" << std::endl;
		return 1;
	}

	SDL_Window * window = SDL_CreateWindow("Particle Simulation Program",
		SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, WIDTH, HEIGHT, 
		SDL_WINDOW_SHOWN);

	if (!window) {
		std::cout << "Could not create the window. " << SDL_GetError() <<
			std::endl;
		SDL_Quit();
		return 2;
	}

	SDL_Renderer * renderer = SDL_CreateRenderer(window, -1,
		SDL_RENDERER_PRESENTVSYNC);

	if (!renderer) {
		std::cout << "Could not create the renderer. " << SDL_GetError() << 
			std::endl;
		SDL_DestroyWindow(window);
		SDL_Quit();
		return 3;
	}

	SDL_Texture * texture = SDL_CreateTexture(renderer,
		SDL_PIXELFORMAT_RGBA8888, SDL_TEXTUREACCESS_STATIC, WIDTH, HEIGHT);

	if (!texture) {
		std::cout << "Could not create the texture. " << SDL_GetError() <<
		   std::endl;
		SDL_DestroyRenderer(renderer);
		SDL_DestroyWindow(window);
		SDL_Quit();
		return 4;
	}

	Uint32 * buffer = new Uint32[WIDTH * HEIGHT];

	memset(buffer, 0, WIDTH * HEIGHT * sizeof(Uint32));

	cint paintCol = WIDTH/2;
	cint paintRow = HEIGHT/2;

	for (int i = 0; i < HEIGHT; i++)
		buffer[i * WIDTH + paintCol] = 0x0FFFF0FF;

	for (int i = 0; i < WIDTH; i++)
		buffer[paintRow * WIDTH + i] = 0x0FFFF0FF;

	for (int i = 0; i < HEIGHT/2 - 1; i++)
		for (int j = 0; j < WIDTH/2 - 1; j++) {
			buffer[i * WIDTH + j] = 0xFFCC00FF;
			buffer[(i * WIDTH + j) + WIDTH/2 + 2] = 0x00CCF0FF;
			buffer[(i + HEIGHT/2 + 1) * WIDTH + j] = 0x0FCC0A00;
			buffer[(i + HEIGHT/2 + 1) * WIDTH + j + WIDTH/2 + 2] = 0xAD0C0A00;
		}



	buffer[40 * WIDTH + 100] = 0xFF00FF;
	buffer[40 * WIDTH + 101] = 0xFF00FF;
	buffer[40 * WIDTH + 102] = 0xFF00FF;
	buffer[40 * WIDTH + 103] = 0xFF0000;
	buffer[40 * WIDTH + 104] = 0xFF0000;

	SDL_UpdateTexture(texture, NULL, buffer, WIDTH * sizeof(Uint32));
	SDL_RenderClear(renderer);
	SDL_RenderCopy(renderer, texture, NULL, NULL);
	SDL_RenderPresent(renderer);

	bool quit = false;

	SDL_Event event;

	while (!quit) {

		while (SDL_PollEvent(&event))
			if (event.type == SDL_QUIT)
				quit = true;
	}

	delete [] buffer;

	SDL_DestroyTexture(texture);
	SDL_DestroyRenderer(renderer);
	SDL_DestroyWindow(window);
	SDL_Quit();

	return 0;
}

