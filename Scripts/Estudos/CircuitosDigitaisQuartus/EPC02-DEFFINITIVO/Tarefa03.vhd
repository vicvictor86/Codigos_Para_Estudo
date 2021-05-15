entity Tarefa03 is
		port (
			A       : in bit;
			S		: out bit
			);
end Tarefa03;

architecture logic of Tarefa03 is
		begin
			S <=  not AB;
end logic; 