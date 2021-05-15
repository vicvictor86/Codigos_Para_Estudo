entity Tarefa04 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa04;

architecture logic of Tarefa04 is
		begin
			S <=  not (A and B);
end logic; 