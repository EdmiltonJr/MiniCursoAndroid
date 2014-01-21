from os import system

def atualizar():
	system("git pull")

def commit(message):
	init = "git add *"
	msg = "git commit -m \""+message+"\""
	system(init)
	system(msg)

def push():
	system("git push origin master")

print "Sincronizando com o repositorio...\n"
atualizar()
print "\nRespositorio sincronizado"
msg = raw_input("Coloque sua mensagem para o commit: ")
print "Commitando...\n"
commit(msg)
print "\nCommitado. Enviando tudo...\n"
push()
print "\nArquivos enviados. Finalizando.."
