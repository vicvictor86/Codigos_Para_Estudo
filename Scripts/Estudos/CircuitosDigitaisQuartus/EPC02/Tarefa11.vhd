entity Tarefa11 is
		port (
			A,B,C,D,E	: in bit;
			S		    : out bit
			);
end Tarefa11;

architecture logic of Tarefa11 is
		begin
			S <=  (A or B) and (C nand D) and not E;
end logic; 