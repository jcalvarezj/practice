/*
 * Basic example of an 
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

	memset(buffer, 255, WIDTH * HEIGHT * sizeof(Uint32));

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

