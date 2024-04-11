%include	'io.asm'

section	.bss
sinput :	resb	255	;reserve a 255 byte space in memory for the users input string
t :	resd	40	;variable globale

section	.text
global _start
_start:
	sub	esp,	4	;allocation mémoire pour la valeur de retour
	call	main
	pop	eax	;récupération de la valeur de retour
	mov	ebx,	0	; valeur de retour du programme
	mov	eax,	1	; code de sortie
	int 0x80
main :	push	ebp	;sauvegarde la valeur de ebp
	mov	ebp,	esp	;nouvelle valeur de ebp
	push	eax	;sauvegarde de eax
	push	ebx	;sauvegarde de ebx
	push	ecx	;sauvegarde de ecx
	push	edx	;sauvegarde de edx
	sub	esp,	0	;allocation des variables locales
	mov	ebx,	0
	imul	ebx,	4
	mov	dword [t+ebx],	3164	;Affect
	mov	ebx,	1
	imul	ebx,	4
	mov	dword [t+ebx],	152	;Affect
	mov	ecx,	1
	imul	ecx,	4
	mov	edx,	0	;mise à 0 des bits de poids fort du dividende
	mov	ebx,	0
	imul	ebx,	4
	mov	eax,	dword [t+ebx]	;affectation des bits de poids faible du dividende
	idiv	dword [t+ecx]
	mov	edx,	edx	;rend explicite l'utilisation de edx pour ne pas que sa valeur soit modifiée
	mov	ebx,	eax
	mov	eax,	1
	imul	eax,	4
	mov	ecx,	dword [t+eax]
	imul	ecx,	ebx
	mov	eax,	0
	imul	eax,	4
	mov	ebx,	dword [t+eax]
	sub	ebx,	ecx
	mov	eax,	2
	imul	eax,	4
	mov	dword [t+eax],	ebx	;Affect
	mov	eax,	2
	imul	eax,	4
	mov	eax,	dword [t+eax]	;Write 1
	call	iprintLF	;Write 2
	add	esp,	0	;désallocation des variables locales
	pop	edx	;restaure edx
	pop	ecx	;restaure ecx
	pop	ebx	;restaure ebx
	pop	eax	;restaure eax
	pop	ebp	;restaure la valeur de ebp
	ret
