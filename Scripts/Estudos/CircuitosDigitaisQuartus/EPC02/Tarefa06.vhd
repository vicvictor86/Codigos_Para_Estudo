--Or com and e not
entity Tarefa06 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa06;

architecture logic of Tarefa06 is
		begin
			S <=  not((not A) and (not B));
end logic; 