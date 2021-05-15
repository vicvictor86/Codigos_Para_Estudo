entity Tarefa02 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa02;

architecture logic of Tarefa02 is
		begin
			S <=  A or B;
end logic; 