entity Tarefa10 is
		port (
			A,B,C,D	: in bit;
			S		: out bit
			);
end Tarefa10;

architecture logic of Tarefa10 is
		begin
			S <=  (A and B) or (C nand D);
end logic; 