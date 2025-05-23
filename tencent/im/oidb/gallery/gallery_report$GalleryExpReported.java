package tencent.im.oidb.gallery;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery_report$GalleryExpReported extends MessageMicro<gallery_report$GalleryExpReported> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBBytesField client_ver;
    public final PBUInt64Field exptime;
    public final PBFloatField mem_size;
    public final PBUInt32Field phone_type = PBField.initUInt32(0);
    public final PBUInt32Field pos;
    public final PBBytesField proxy_bytes;
    public final PBBytesField rowkey;
    public final PBUInt32Field source;

    static {
        String[] strArr = {"phone_type", "client_ver", "source", "mem_size", "city", "exptime", c.G, "rowkey", "proxy_bytes"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 37, 42, 48, 56, 66, 402}, strArr, new Object[]{0, byteStringMicro, 0, Float.valueOf(0.0f), byteStringMicro, 0L, 0, byteStringMicro, byteStringMicro}, gallery_report$GalleryExpReported.class);
    }

    public gallery_report$GalleryExpReported() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_ver = PBField.initBytes(byteStringMicro);
        this.source = PBField.initUInt32(0);
        this.mem_size = PBField.initFloat(0.0f);
        this.city = PBField.initBytes(byteStringMicro);
        this.exptime = PBField.initUInt64(0L);
        this.pos = PBField.initUInt32(0);
        this.rowkey = PBField.initBytes(byteStringMicro);
        this.proxy_bytes = PBField.initBytes(byteStringMicro);
    }
}
