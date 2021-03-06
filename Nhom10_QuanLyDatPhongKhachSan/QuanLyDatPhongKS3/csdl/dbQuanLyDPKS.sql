USE [master]
GO
/****** Object:  Database [dbqldpKhachSan]    Script Date: 08/05/2019 11:50:08 CH ******/
CREATE DATABASE [dbqldpKhachSan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'master', FILENAME = N'D:\DOCUMENTS\JAVA\N10_QuanLyDatPhongKS\CSDL Test\dbqldpKhachSan.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 10%)
 LOG ON 
( NAME = N'mastlog', FILENAME = N'D:\DOCUMENTS\JAVA\N10_QuanLyDatPhongKS\CSDL Test\dbqldpKhachSan_log.ldf' , SIZE = 2304KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbqldpKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbqldpKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbqldpKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbqldpKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbqldpKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbqldpKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET RECOVERY FULL 
GO
ALTER DATABASE [dbqldpKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [dbqldpKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbqldpKhachSan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbqldpKhachSan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbqldpKhachSan] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'dbqldpKhachSan', N'ON'
GO
USE [dbqldpKhachSan]
GO
/****** Object:  User [##MS_PolicyEventProcessingLogin##]    Script Date: 08/05/2019 11:50:08 CH ******/
CREATE USER [##MS_PolicyEventProcessingLogin##] FOR LOGIN [##MS_PolicyEventProcessingLogin##] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [##MS_AgentSigningCertificate##]    Script Date: 08/05/2019 11:50:08 CH ******/
CREATE USER [##MS_AgentSigningCertificate##] FOR LOGIN [##MS_AgentSigningCertificate##]
GO
/****** Object:  Table [dbo].[tbCTHoaDon]    Script Date: 08/05/2019 11:50:08 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCTHoaDon](
	[maHd] [nvarchar](30) NOT NULL,
	[soPhong] [nvarchar](30) NOT NULL,
	[ngayDen] [date] NULL,
	[ngayDi] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHd] ASC,
	[soPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbCTHoaDonDaXoa]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCTHoaDonDaXoa](
	[maHD] [nvarchar](30) NULL,
	[soPhong] [nvarchar](30) NULL,
	[ngayDen] [date] NULL,
	[ngayDi] [date] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbHoaDon]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbHoaDon](
	[maHd] [nvarchar](30) NOT NULL,
	[maNV] [nvarchar](30) NOT NULL,
	[maKH] [nvarchar](30) NOT NULL,
	[ngayThanhToan] [date] NULL,
	[giamGia] [real] NULL,
	[daThanhToan] [bit] NULL,
 CONSTRAINT [PK_tbHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbHoaDonThanhToan]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbHoaDonThanhToan](
	[maHD] [nvarchar](30) NULL,
	[tongTien] [real] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbKhachHang]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbKhachHang](
	[maKH] [nvarchar](30) NOT NULL,
	[CMND] [nvarchar](20) NOT NULL,
	[hoTen] [nvarchar](300) NOT NULL,
	[gioiTinh] [bit] NULL,
	[diaChi] [nvarchar](300) NULL,
	[sdt] [nvarchar](20) NULL,
	[loaiKH] [nvarchar](250) NULL,
 CONSTRAINT [PK_tbKhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbLoaiPhong]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbLoaiPhong](
	[maLoaiPh] [nvarchar](30) NOT NULL,
	[tenLoaiPh] [nvarchar](100) NULL,
	[donGia] [real] NOT NULL,
 CONSTRAINT [PK_tbLoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbNhanVien]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbNhanVien](
	[maNV] [nvarchar](30) NOT NULL,
	[hoTen] [nvarchar](300) NOT NULL,
	[CMND] [nvarchar](20) NOT NULL,
	[diaChi] [nvarchar](300) NULL,
	[sdt] [nvarchar](20) NULL,
	[ngayVaoLam] [date] NOT NULL,
	[taiKhoan] [nvarchar](20) NOT NULL,
	[matKhau] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbNhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbPhong]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPhong](
	[soPhong] [nvarchar](30) NOT NULL,
	[tinhTrang] [bit] NULL,
	[maLoaiPh] [nvarchar](30) NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[soPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD1', N'101', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-11' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD3', N'201', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD3', N'204', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD3', N'302', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD4', N'105', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-11' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD4', N'203', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-11' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD4', N'301', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-11' AS Date))
INSERT [dbo].[tbCTHoaDon] ([maHd], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD5', N'202', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-10' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD6', N'104', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-10' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD7', N'102', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD2', N'103', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-09' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD8', N'102', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD10', N'102', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-10' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD12', N'103', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-10' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD9', N'104', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD9', N'304', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbCTHoaDonDaXoa] ([maHD], [soPhong], [ngayDen], [ngayDi]) VALUES (N'HD11', N'102', CAST(N'2019-05-08' AS Date), CAST(N'2019-05-08' AS Date))
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD1', N'NV1', N'KH1', NULL, 0, 0)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD10', N'NV1', N'KH10', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD11', N'NV1', N'KH11', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD12', N'NV1', N'KH12', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD2', N'NV1', N'KH2', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD3', N'NV1', N'KH3', NULL, 0, 0)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD4', N'NV1', N'KH4', NULL, 0, 0)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD5', N'NV1', N'KH5', NULL, 0, 0)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD6', N'NV1', N'KH6', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD7', N'NV1', N'KH7', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD8', N'NV1', N'KH8', CAST(N'2019-05-08' AS Date), 0.1, 1)
INSERT [dbo].[tbHoaDon] ([maHd], [maNV], [maKH], [ngayThanhToan], [giamGia], [daThanhToan]) VALUES (N'HD9', N'NV1', N'KH9', CAST(N'2019-05-08' AS Date), 0, 1)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD7', 220000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD2', 220000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD8', 198000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD10', 220000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD12', 220000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD6', 300000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD6', 300000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD9', 600000)
INSERT [dbo].[tbHoaDonThanhToan] ([maHD], [tongTien]) VALUES (N'HD11', 220000)
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH1', N'285613633', N'Minh Chien', 1, N'Binh Phuoc', N'0383968311', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH10', N'254136987', N'Xuan Khang', 1, N'Long An', N'0963963258', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH11', N'265364125', N'Hoang Tien', 1, N'Binh Dinh', N'0963521478', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH12', N'258963147', N'Hoang Thuc', 1, N'Ben Tre', N'0963258741', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH2', N'293541787', N'Thanh Tri', 1, N'Ninh Thuan', N'0963254178', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH3', N'287415632', N'Trong Tuan', 1, N'Gia Lai', N'0965412387', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH4', N'289632541', N'Quoc Thang', 1, N'TPHCM', N'0987456321', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH5', N'236541789', N'Gia Hung', 1, N'Quang Nam', N'0356247851', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH6', N'256398314', N'Tuan Anh', 1, N'Nghe An', N'0963254188', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH7', N'258963147', N'Hoang Thuc', 1, N'Ben Tre', N'0963258741', N'Thường')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH8', N'258963147', N'Hoang Thuc', 1, N'Ben Tre', N'0963258741', N'Thân thiết')
INSERT [dbo].[tbKhachHang] ([maKH], [CMND], [hoTen], [gioiTinh], [diaChi], [sdt], [loaiKH]) VALUES (N'KH9', N'258963146', N'Vinh Hoang', 1, N'Binh Duong', N'0852147963', N'Thường')
INSERT [dbo].[tbLoaiPhong] ([maLoaiPh], [tenLoaiPh], [donGia]) VALUES (N'LP1', N'Phòng đơn', 220000)
INSERT [dbo].[tbLoaiPhong] ([maLoaiPh], [tenLoaiPh], [donGia]) VALUES (N'LP2', N'Phòng đôi', 300000)
INSERT [dbo].[tbNhanVien] ([maNV], [hoTen], [CMND], [diaChi], [sdt], [ngayVaoLam], [taiKhoan], [matKhau]) VALUES (N'NV1', N'Trần Hoàng Duy', N'025874656', N'43/19 đường 21, phường 8, quận Gò Vấp, TPHCM', N'0969775451', CAST(N'2018-02-09' AS Date), N'duy', N'duy123')
INSERT [dbo].[tbNhanVien] ([maNV], [hoTen], [CMND], [diaChi], [sdt], [ngayVaoLam], [taiKhoan], [matKhau]) VALUES (N'NV2', N'Nguyễn Quang Trực ', N'025824635', N'45 đường Nguyễn Thái Sơn', N'0332797697', CAST(N'2017-05-24' AS Date), N'Titanic456', N'truc123')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'101', 1, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'102', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'103', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'104', 0, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'105', 1, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'201', 1, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'202', 1, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'203', 1, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'204', 1, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'205', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'301', 1, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'302', 1, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'303', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'304', 0, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'305', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'401', 0, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'402', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'403', 0, N'LP1')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'404', 0, N'LP2')
INSERT [dbo].[tbPhong] ([soPhong], [tinhTrang], [maLoaiPh]) VALUES (N'405', 0, N'LP1')
ALTER TABLE [dbo].[tbHoaDon] ADD  CONSTRAINT [DF_tbHoaDon_giamGia]  DEFAULT ((0)) FOR [giamGia]
GO
ALTER TABLE [dbo].[tbNhanVien] ADD  CONSTRAINT [DF_NGVL]  DEFAULT (getdate()) FOR [ngayVaoLam]
GO
ALTER TABLE [dbo].[tbCTHoaDon]  WITH CHECK ADD  CONSTRAINT [CTHD_HD_FK] FOREIGN KEY([maHd])
REFERENCES [dbo].[tbHoaDon] ([maHd])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbCTHoaDon] CHECK CONSTRAINT [CTHD_HD_FK]
GO
ALTER TABLE [dbo].[tbCTHoaDon]  WITH CHECK ADD  CONSTRAINT [CTHD_PH_FK] FOREIGN KEY([soPhong])
REFERENCES [dbo].[tbPhong] ([soPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbCTHoaDon] CHECK CONSTRAINT [CTHD_PH_FK]
GO
ALTER TABLE [dbo].[tbHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HD_KH] FOREIGN KEY([maKH])
REFERENCES [dbo].[tbKhachHang] ([maKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbHoaDon] CHECK CONSTRAINT [FK_HD_KH]
GO
ALTER TABLE [dbo].[tbHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HD_NV] FOREIGN KEY([maNV])
REFERENCES [dbo].[tbNhanVien] ([maNV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tbHoaDon] CHECK CONSTRAINT [FK_HD_NV]
GO
ALTER TABLE [dbo].[tbPhong]  WITH CHECK ADD  CONSTRAINT [FK_LP_PH] FOREIGN KEY([maLoaiPh])
REFERENCES [dbo].[tbLoaiPhong] ([maLoaiPh])
GO
ALTER TABLE [dbo].[tbPhong] CHECK CONSTRAINT [FK_LP_PH]
GO
ALTER TABLE [dbo].[tbNhanVien]  WITH CHECK ADD  CONSTRAINT [CK__tbNhanVie__ngayV__46E78A0C] CHECK  (([ngayvaolam]<=getdate()))
GO
ALTER TABLE [dbo].[tbNhanVien] CHECK CONSTRAINT [CK__tbNhanVie__ngayV__46E78A0C]
GO
ALTER TABLE [dbo].[tbNhanVien]  WITH CHECK ADD  CONSTRAINT [CK__tbNhanVien__CMND__47DBAE45] CHECK  ((len([cmnd])=(9) OR len([cmnd])=(12)))
GO
ALTER TABLE [dbo].[tbNhanVien] CHECK CONSTRAINT [CK__tbNhanVien__CMND__47DBAE45]
GO
/****** Object:  StoredProcedure [dbo].[LayDanhSachHoaDonDaThanhToan]    Script Date: 08/05/2019 11:50:09 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[LayDanhSachHoaDonDaThanhToan]
as
select hd.maHd,ct.soPhong,hoTen,ngayThanhToan,giamGia,tinhTrang
from tbKhachHang kh join tbHoaDon hd on hd.maKH = kh.maKH
join tbCTHoaDon ct on ct.maHd = hd.maHd join tbPhong ph on ph.soPhong = ct.soPhong
join tbLoaiPhong lp on lp.maLoaiPh = ph.soPhong
where daThanhToan=1
GO
USE [master]
GO
ALTER DATABASE [dbqldpKhachSan] SET  READ_WRITE 
GO
