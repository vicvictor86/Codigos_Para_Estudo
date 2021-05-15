--Nand com or e not
entity Tarefa07 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa07;

architecture logic of Tarefa07 is
		begin
			S <=  (not A) or (not B);
end logic; 