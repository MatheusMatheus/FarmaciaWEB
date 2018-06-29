use FarmaciaWEB;
show tables;
drop database FarmaciaWEB;

drop table MEDICAMENTO;

select c.cpf, c.nome, c.telefone, c.email, 
c.dataNascimento, c.sexo, c.perfil, c.LOCALIZACAO_id,
c.LOGIN_id, l.id, l.cep,
l.endereco, l.cidade, l.estado,
lo.id, lo.senha, lo.usuario
from CLIENTE as c inner join LOCALIZACAO as l on l.id = c.LOCALIZACAO_id
inner join LOGIN as lo on lo.id = c.LOGIN_id;

select f.cnpj, f.email, f.logo_path, f.nome_fantasia,
f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id,
f.LOGIN_id, l.id, l.cep, l.endereco, 
l.cidade, l.estado,
lo.id, lo.senha, lo.usuario
from FARMACIA as f inner join LOCALIZACAO as l on f.LOCALIZACAO_id = l.id
inner join LOGIN as lo on lo.id = f.LOGIN_id;

select c.cpf, lo.usuario
from CLIENTE as c
inner join LOGIN as lo on c.LOGIN_id = lo.id and lo.usuario = 'matheus@gmail.com';


select distinct f.cnpj, f.logo_path, f.nome_fantasia, f.perfil, 
f.razao_social, f.telefone, f.LOCALIZACAO_id, f.LOGIN_id,
m.id, m.nome, m.preco, m.categoria, m.descricao, m.fabricante, m.foto_path, 
m.quantidade, m.tipo, m.validade, 
i.id, i.FARMACIA_cnpj, i.MEDICAMENTO_id, i.dataInsercao,
l.id, l.cep, l.endereco, l.cidade, l.estado,
lo.id, lo.senha, lo.usuario
from INSERE as i 
inner join FARMACIA as f on i.FARMACIA_cnpj = f.cnpj
inner join MEDICAMENTO as m on m.id = i.MEDICAMENTO_id
inner join LOCALIZACAO as l on l.id = f.LOCALIZACAO_id
inner join LOGIN as lo on lo.id = f.LOGIN_id
and f.cnpj = '651651616161616';

select c.cpf, c.nome, c.telefone, c.email, c.dataNascimento,
c.sexo, c.perfil, c.LOCALIZACAO_id, c.LOGIN_id,
m.id, m.categoria, m.descricao, m.fabricante, m.foto_path, m.nome,
m.preco, m.quantidade, m.tipo, m.validade,
v.CLIENTE_cpf, v.MEDICAMENTO_id, v.dataVenda, v.tipo_pagamento,
l.id, l.cep, l.endereco, l.cidade, l.estado,
lo.id, lo.senha, lo.usuario
from VENDA as v 
inner join MEDICAMENTO as m on m.id = v.MEDICAMENTO_id
inner join CLIENTE c on c.cpf = v.CLIENTE_cpf
inner join LOCALIZACAO as l on l.id = c.LOCALIZACAO_id
inner join LOGIN as lo on lo.id = c.LOGIN_id;

select * from CLIENTE;
select c.cpf, c.nome, c.telefone, c.email, c.dataNascimento,
c.sexo, c.perfil, c.LOCALIZACAO_id, c.LOGIN_id,
c.LOGIN_id,
lo.id, lo.senha, lo.usuario 
from CLIENTE as c inner join LOGIN as lo on lo.senha = '12345' and lo.usuario = 'matheus@gmail.com';


select f.cnpj, f.logo_path, f.nome_fantasia, f.LOGIN_id, 
f.perfil, f.razao_social, f.telefone, f.LOCALIZACAO_id, 
l.id, l.cep, l.endereco, l.cidade, l.estado, 
lo.id, lo.senha, lo.usuario 
from FARMACIA as f, LOCALIZACAO as l, LOGIN as lo 
where f.LOCALIZACAO_id = l.id 
and f.LOGIN_id = lo.id
and lo.usuario = 'joao@email.com' and lo.senha = '123';

select * from FARMACIA, LOGIN where cnpj = '651651616161616' and FARMACIA.LOGIN_id = LOGIN.id;

select * from MEDICAMENTO;
select * from MEDICAMENTO where id  = '1530224878946';
update MEDICAMENTO set quantidade = 100 where id  = '1530224878946';

select * from LOCALIZACAO where id = 1530247225862

