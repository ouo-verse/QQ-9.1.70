package tencent.im.oidb.gallery;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery_report$GallerySocialReported extends MessageMicro<gallery_report$GallerySocialReported> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field action;
    public final PBBytesField city;
    public final PBBytesField client_ver;
    public final PBUInt32Field is_read_end;
    public final PBUInt32Field phone_type = PBField.initUInt32(0);
    public final PBUInt32Field pos;
    public final PBBytesField proxy_bytes;
    public final PBBytesField rowkey;
    public final PBInt32Field share_state;
    public final PBUInt32Field source;

    static {
        String[] strArr = {"phone_type", "client_ver", "source", "city", c.G, "is_read_end", "rowkey", "share_state", "action", "proxy_bytes"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 42, 88, 96, 106, 112, 120, 402}, strArr, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0, 0, byteStringMicro, 0, 0, byteStringMicro}, gallery_report$GallerySocialReported.class);
    }

    public gallery_report$GallerySocialReported() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_ver = PBField.initBytes(byteStringMicro);
        this.source = PBField.initUInt32(0);
        this.city = PBField.initBytes(byteStringMicro);
        this.pos = PBField.initUInt32(0);
        this.is_read_end = PBField.initUInt32(0);
        this.rowkey = PBField.initBytes(byteStringMicro);
        this.share_state = PBField.initInt32(0);
        this.action = PBField.initInt32(0);
        this.proxy_bytes = PBField.initBytes(byteStringMicro);
    }
}
