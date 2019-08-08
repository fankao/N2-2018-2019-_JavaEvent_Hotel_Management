
use dbqldpKhachSan
go
create trigger trg_capNhatPhongTrong on tbCTHoaDon
after insert as
begin
update tbPhong set tinhTrang=1
where soPhong in(select soPhong from tbCTHoaDon)
end
go
create trigger trg_capNhatPhong on tbcthoadon for delete as
begin
update tbPhong set tinhTrang=0
where soPhong not in(select soPhong from tbCTHoaDon)
end
go