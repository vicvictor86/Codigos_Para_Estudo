entity Tarefa12 is
		port (
			A,B,C,D,E	: in bit;
			S		    : out bit
			);
end Tarefa12;

architecture logic of Tarefa12 is
		begin
			S <=  not(((A nand B) or (C xor D)) and not E);
end logic; 