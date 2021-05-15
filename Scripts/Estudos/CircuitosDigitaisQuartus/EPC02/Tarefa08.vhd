entity Tarefa08 is
		port (
			A,B	: in bit;
			S		: out bit
			);
end Tarefa08;

architecture logic of Tarefa08 is
		begin
			S <=  A xor B;
end logic; 