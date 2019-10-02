filetype plugin indent on
syntax on
set colorcolumn=80
set background=dark
set ruler
set number
set cursorline
set tabstop=4
set shiftwidth=4
set matchpairs+=<:> 
ab psvm public static void main(String[] args) { <C-v> <CR> }
ab sout System.out.println("");
ab cout cout << "" << var << endl;
ab fori for(int i=0; i<n; i++) { <C-v> <CR> }
ab foreach for(Type t: structure) { <C-v> <CR> }
autocmd BufNewFile *.cpp 0r ~/.vim/templates/skeleton.cpp
autocmd BufNewFile *.c 0r ~/.vim/templates/skeleton.c
autocmd BufNewFile *.h 0r ~/.vim/templates/skeleton.h
autocmd BufNewFile *.html 0r ~/.vim/templates/skeleton.html
