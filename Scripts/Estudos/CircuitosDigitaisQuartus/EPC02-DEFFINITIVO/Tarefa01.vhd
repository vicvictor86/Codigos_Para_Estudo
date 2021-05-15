entity Tarefa01 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa01;

architecture logic of Tarefa01 is
		begin
			S <=  A and B;
end logic; 