entity Tarefa12 is
		port (
			A,B	: in bit;
			S   : out bit
			);
end Tarefa12;

architecture logic of Tarefa12 is
		begin
			S <=  (A nand B) and (A or B);
end logic; 