package w7;

import com.qzone.util.image.b;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.StorageNTSdkExtInfo$ExifInfo;
import qzone.StoragePhotoSdkCommon$EnvInfo;
import qzone.StoragePhotoSdkCommon$ImgInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006J\n\u0010\u000f\u001a\u00020\u0006*\u00020\u000e\u00a8\u0006\u0012"}, d2 = {"Lw7/a;", "", "", "a", "Lcom/qzone/util/image/b;", "exif", "", "path", "d", "Lqzone/StoragePhotoSdkCommon$EnvInfo;", "b", "filePath", "Lqzone/StorageNTSdkExtInfo$ExifInfo;", "c", "Lqzone/StoragePhotoSdkCommon$ImgInfo;", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f444706a = new a();

    a() {
    }

    private final int a() {
        int networkType = NetworkState.getNetworkType();
        if (networkType == 1) {
            return 1;
        }
        if (networkType == 2) {
            return 3;
        }
        if (networkType == 3) {
            return 2;
        }
        if (networkType != 4) {
            return networkType != 5 ? 0 : 7;
        }
        return 6;
    }

    private final String d(b exif, String path) {
        String format;
        String attribute = exif.getAttribute("DateTime");
        if (attribute == null) {
            String valueOf = String.valueOf(new File(path).lastModified());
            QLog.d("QZNTUploadUtil", 4, "exif is invalid, get shoot time from file lastModified:" + valueOf);
            if (Intrinsics.areEqual(valueOf, "0") || (format = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(Long.parseLong(valueOf)))) == null) {
                return "";
            }
            QLog.d("QZNTUploadUtil", 4, "convert file lastModified to shoot time:" + format);
            return format;
        }
        QLog.d("QZNTUploadUtil", 4, "exif is valid,get shoot time:" + attribute);
        return attribute;
    }

    public final StoragePhotoSdkCommon$EnvInfo b() {
        StoragePhotoSdkCommon$EnvInfo storagePhotoSdkCommon$EnvInfo = new StoragePhotoSdkCommon$EnvInfo();
        storagePhotoSdkCommon$EnvInfo.qua.set(QUA.getQUA3());
        storagePhotoSdkCommon$EnvInfo.net.set(a());
        storagePhotoSdkCommon$EnvInfo.operators.set(NetworkState.getProviderName());
        storagePhotoSdkCommon$EnvInfo.device_info.set(PlatformInfor.g().getDeviceInfor());
        storagePhotoSdkCommon$EnvInfo.source.set(1);
        return storagePhotoSdkCommon$EnvInfo;
    }

    public final StorageNTSdkExtInfo$ExifInfo c(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            if (!JpegExifReader.isCrashJpeg(filePath)) {
                b bVar = new b(filePath);
                HashMap<String, String> b16 = com.qzone.util.image.a.b(bVar);
                StorageNTSdkExtInfo$ExifInfo storageNTSdkExtInfo$ExifInfo = new StorageNTSdkExtInfo$ExifInfo();
                PBStringField pBStringField = storageNTSdkExtInfo$ExifInfo.camera_maker;
                String str = b16.get(com.qzone.util.image.a.a("Make"));
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                pBStringField.set(str);
                PBStringField pBStringField2 = storageNTSdkExtInfo$ExifInfo.camera_model;
                String str3 = b16.get(com.qzone.util.image.a.a("Model"));
                if (str3 == null) {
                    str3 = "";
                }
                pBStringField2.set(str3);
                PBStringField pBStringField3 = storageNTSdkExtInfo$ExifInfo.latitude;
                String str4 = b16.get(com.qzone.util.image.a.a("GPSLatitude"));
                if (str4 == null) {
                    str4 = "";
                }
                pBStringField3.set(str4);
                PBStringField pBStringField4 = storageNTSdkExtInfo$ExifInfo.latitude_ref;
                String str5 = b16.get(com.qzone.util.image.a.a("GPSLatitudeRef"));
                if (str5 == null) {
                    str5 = "";
                }
                pBStringField4.set(str5);
                PBStringField pBStringField5 = storageNTSdkExtInfo$ExifInfo.longitude;
                String str6 = b16.get(com.qzone.util.image.a.a("GPSLongitude"));
                if (str6 == null) {
                    str6 = "";
                }
                pBStringField5.set(str6);
                PBStringField pBStringField6 = storageNTSdkExtInfo$ExifInfo.longitude_ref;
                String str7 = b16.get(com.qzone.util.image.a.a("GPSLongitudeRef"));
                if (str7 != null) {
                    str2 = str7;
                }
                pBStringField6.set(str2);
                storageNTSdkExtInfo$ExifInfo.time.set(d(bVar, filePath));
                return storageNTSdkExtInfo$ExifInfo;
            }
            return new StorageNTSdkExtInfo$ExifInfo();
        } catch (Exception e16) {
            QLog.e("QZNTUploadUtil", 1, "getExifInfo error:" + e16);
            return new StorageNTSdkExtInfo$ExifInfo();
        }
    }

    public final String e(StoragePhotoSdkCommon$ImgInfo storagePhotoSdkCommon$ImgInfo) {
        Intrinsics.checkNotNullParameter(storagePhotoSdkCommon$ImgInfo, "<this>");
        return "imgInfo{img_class=" + storagePhotoSdkCommon$ImgInfo.img_class.get() + ",img_size=" + storagePhotoSdkCommon$ImgInfo.img_size.get() + ",img_width=" + storagePhotoSdkCommon$ImgInfo.img_width.get() + ",img_height=" + storagePhotoSdkCommon$ImgInfo.img_height.get() + ",img_type=" + storagePhotoSdkCommon$ImgInfo.img_type.get() + ",img_md5=" + storagePhotoSdkCommon$ImgInfo.img_md5.get() + ",img_url=" + storagePhotoSdkCommon$ImgInfo.img_url.get() + "}";
    }
}
