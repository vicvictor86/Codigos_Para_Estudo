entity TAREFA is
		port (
			A,B,C,D	: in bit;
			S		: out bit
			);
end TAREFA;

architecture logic of TAREFA is
		begin
			S1 <= NOT A and NOT B AND NOT C AND D;
			S2 <= NOT A AND NOT B AND C AND NOT D;
			S3 <= NOT A AND B AND C AND D;
			S4 <= A AND NOT B AND NOT C AND D;
			S5 <= A AND B AND NOT C AND NOT D;
			S6 <= A AND B AND C AND D;
			S <= S1 OR S2 OR S3 OR S4 OR S5 OR S6
end logic; 
