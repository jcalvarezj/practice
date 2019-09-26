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
autocmd BufNewFile *.cpp 0r ~/.vim/templates/skeleton.cpp
autocmd BufNewFile *.c 0r ~/.vim/templates/skeleton.c
autocmd BufNewFile *.html 0r ~/.vim/templates/skeleton.html
