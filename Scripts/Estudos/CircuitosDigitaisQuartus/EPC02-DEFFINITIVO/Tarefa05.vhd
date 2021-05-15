entity Tarefa05 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa05;

architecture logic of Tarefa05 is
		begin
			S <= not (A or B);
end logic; 