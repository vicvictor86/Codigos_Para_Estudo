--Xor com And, or, not
entity Tarefa09 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa09;

architecture logic of Tarefa09 is
		begin
			S <=  (not A and B) or (A and not B);
end logic; 