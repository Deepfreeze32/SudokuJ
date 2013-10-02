%sudoku(1,X1,X2,6,X3,9,X4,X5,X6,3,4,8,1,X7,X8,6,2,9,2,6,9,3,4,X9,X10,1,7,8,3,X11,4,X12,1,X13,X14,2,X15,1,4,X16,8,2,X17,5,6,7,2,X18,9,6,3,X19,8,1,6,8,X20,2,9,4,X21,3,X22,X23,9,X24,X25,1,7,2,6,X26,X27,7,2,X28,3,6,1,X29,8).

valid(L) :-  member(1,L),
member(2,L),
member(3,L),
member(4,L),
member(5,L),
member(6,L),
member(7,L),
member(8,L),
member(9,L).

sudoku(A1,A2,A3,A4,A5,A6,A7,A8,A9,B1,B2,B3,B4,B5,B6,B7,B8,B9,C1,C2,C3,C4,C5,C6,C7,C8,C9,D1,D2,D3,D4,D5,D6,D7,D8,D9,E1,E2,E3,E4,E5,E6,E7,E8,E9,F1,F2,F3,F4,F5,F6,F7,F8,F9,G1,G2,G3,G4,G5,G6,G7,G8,G9,H1,H2,H3,H4,H5,H6,H7,H8,H9,I1,I2,I3,I4,I5,I6,I7,I8,I9) :-
%rows%
valid([A1,A2,A3,A4,A5,A6,A7,A8,A9]),
valid([B1,B2,B3,B4,B5,B6,B7,B8,B9]),
valid([C1,C2,C3,C4,C5,C6,C7,C8,C9]),
valid([D1,D2,D3,D4,D5,D6,D7,D8,D9]),
valid([E1,E2,E3,E4,E5,E6,E7,E8,E9]),
valid([F1,F2,F3,F4,F5,F6,F7,F8,F9]),
valid([G1,G2,G3,G4,G5,G6,G7,G8,G9]),
valid([H1,H2,H3,H4,H5,H6,H7,H8,H9]),
valid([I1,I2,I3,I4,I5,I6,I7,I8,I9]),
%Columns%
valid([A1,B1,C1,D1,E1,F1,G1,H1,I1]),
valid([A2,B2,C2,D2,E2,F2,G2,H2,I2]),
valid([A3,B3,C3,D3,E3,F3,G3,H3,I3]),
valid([A4,B4,C4,D4,E4,F4,G4,H4,I4]),
valid([A5,B5,C5,D5,E5,F5,G5,H5,I5]),
valid([A6,B6,C6,D6,E6,F6,G6,H6,I6]),
valid([A7,B7,C7,D7,E7,F7,G7,H7,I7]),
valid([A8,B8,C8,D8,E8,F8,G8,H8,I8]),
valid([A9,B9,C9,D9,E9,F9,G9,H9,I9]),
%boxes%
valid([A1,A2,A3,B1,B2,B3,C1,C2,C3]),
valid([A4,A5,A6,B4,B5,B6,C4,C5,C6]),
valid([A7,A8,A9,B7,B8,B9,C7,C8,C9]),
valid([D1,D2,D3,E1,E2,E3,F1,F2,F3]),
valid([D4,D5,D6,E4,E5,E6,F4,F5,F6]),
valid([D7,D8,D9,E7,E8,E9,F7,F8,F9]),
valid([G1,G2,G3,H1,H2,H3,I1,I2,I3]),
valid([G4,G5,G6,H4,H5,H6,I4,I5,I6]),
valid([G7,G8,G9,H7,H8,H9,I7,I8,I9]).
