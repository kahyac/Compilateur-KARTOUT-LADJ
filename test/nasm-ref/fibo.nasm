%include	'io.asm'

section	.bss
sinput :	resb	255	;reserve a 255 byte space in memory for the users input string

section	.text
global _start
_start:
	sub	esp,	4	;allocation mémoire pour la valeur de retour
	call	main
	pop	eax	;récupération de la valeur de retour
	mov	ebx,	0	; valeur de retour du programme
	mov	eax,	1	; code de sortie
	int 0x80
fibo :	push	ebp	;sauvegarde la valeur de ebp
	mov	ebp,	esp	;nouvelle valeur de ebp
	push	eax	;sauvegarde de eax
	push	ebx	;sauvegarde de ebx
	push	ecx	;sauvegarde de ecx
	push	edx	;sauvegarde de edx
	sub	esp,	0	;allocation des variables locales
	mov	eax,	1	;Affect
	cmp	dword [ebp+12],	2	;JumpIfLess 1
	jl	l2	;JumpIfLess 2
	mov	eax,	0	;Affect
l2 :	cmp	eax,	0	;JumpIfEqual 1
	je	l0	;JumpIfEqual 2
	mov	dword [ebp+8],	1	;ecriture de la valeur de retour
	add	esp,	0	;désallocation des variables locales
	pop	edx	;restaure edx
	pop	ecx	;restaure ecx
	pop	ebx	;restaure ebx
	pop	eax	;restaure eax
	pop	ebp	;restaure la valeur de ebp
	ret
	jmp	l1	;Jump
l0 :	mov	eax,	dword [ebp+12]
	sub	eax,	1
	push	eax	;Param
	sub	esp,	4	;allocation mémoire pour la valeur de retour
	call	fibo
	pop	ecx	;récupération de la valeur de retour
	add	esp,	4	;désallocation des arguments
	mov	eax,	dword [ebp+12]
	sub	eax,	2
	push	eax	;Param
	sub	esp,	4	;allocation mémoire pour la valeur de retour
	call	fibo
	pop	ebx	;récupération de la valeur de retour
	add	esp,	4	;désallocation des arguments
	mov	eax,	ecx
	add	eax,	ebx
	mov	dword [ebp+8],	eax	;ecriture de la valeur de retour
	add	esp,	0	;désallocation des variables locales
	pop	edx	;restaure edx
	pop	ecx	;restaure ecx
	pop	ebx	;restaure ebx
	pop	eax	;restaure eax
	pop	ebp	;restaure la valeur de ebp
	ret
l1 :	add	esp,	0	;désallocation des variables locales
	pop	edx	;restaure edx
	pop	ecx	;restaure ecx
	pop	ebx	;restaure ebx
	pop	eax	;restaure eax
	pop	ebp	;restaure la valeur de ebp
	ret
main :	push	ebp	;sauvegarde la valeur de ebp
	mov	ebp,	esp	;nouvelle valeur de ebp
	push	eax	;sauvegarde de eax
	push	ebx	;sauvegarde de ebx
	push	ecx	;sauvegarde de ecx
	push	edx	;sauvegarde de edx
	sub	esp,	0	;allocation des variables locales
	push	3	;Param
	sub	esp,	4	;allocation mémoire pour la valeur de retour
	call	fibo
	pop	eax	;récupération de la valeur de retour
	add	esp,	4	;désallocation des arguments
	mov	eax,	eax	;Write 1
	call	iprintLF	;Write 2
	add	esp,	0	;désallocation des variables locales
	pop	edx	;restaure edx
	pop	ecx	;restaure ecx
	pop	ebx	;restaure ebx
	pop	eax	;restaure eax
	pop	ebp	;restaure la valeur de ebp
	ret
