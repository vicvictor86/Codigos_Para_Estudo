entity Tarefa06 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa06;

architecture logic of Tarefa06 is
		begin
			S <=  A and B;
end logic; 