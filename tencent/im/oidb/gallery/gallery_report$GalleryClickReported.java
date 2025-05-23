package tencent.im.oidb.gallery;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery_report$GalleryClickReported extends MessageMicro<gallery_report$GalleryClickReported> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city;
    public final PBUInt64Field clicktime;
    public final PBBytesField client_ver;
    public final PBUInt64Field go_away_time;
    public final PBUInt32Field is_read_end;
    public final PBUInt32Field is_read_repeaded;
    public final PBFloatField mem_size;
    public final PBUInt64Field no_use_time;
    public final PBRepeatMessageField<gallery_report$OnePicReported> one_pic_reported;
    public final PBUInt32Field phone_type = PBField.initUInt32(0);
    public final PBUInt32Field pic_num;
    public final PBUInt32Field pos;
    public final PBBytesField proxy_bytes;
    public final PBBytesField rowkey;
    public final PBUInt32Field source;

    static {
        String[] strArr = {"phone_type", "client_ver", "source", "mem_size", "city", "clicktime", "go_away_time", "no_use_time", "one_pic_reported", WinkDaTongReportConstant.ElementParamKey.PIC_NUM, c.G, "is_read_end", "rowkey", "is_read_repeaded", "proxy_bytes"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 37, 42, 48, 56, 64, 74, 80, 88, 96, 106, 112, 402}, strArr, new Object[]{0, byteStringMicro, 0, Float.valueOf(0.0f), byteStringMicro, 0L, 0L, 0L, null, 0, 0, 0, byteStringMicro, 0, byteStringMicro}, gallery_report$GalleryClickReported.class);
    }

    public gallery_report$GalleryClickReported() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.client_ver = PBField.initBytes(byteStringMicro);
        this.source = PBField.initUInt32(0);
        this.mem_size = PBField.initFloat(0.0f);
        this.city = PBField.initBytes(byteStringMicro);
        this.clicktime = PBField.initUInt64(0L);
        this.go_away_time = PBField.initUInt64(0L);
        this.no_use_time = PBField.initUInt64(0L);
        this.one_pic_reported = PBField.initRepeatMessage(gallery_report$OnePicReported.class);
        this.pic_num = PBField.initUInt32(0);
        this.pos = PBField.initUInt32(0);
        this.is_read_end = PBField.initUInt32(0);
        this.rowkey = PBField.initBytes(byteStringMicro);
        this.is_read_repeaded = PBField.initUInt32(0);
        this.proxy_bytes = PBField.initBytes(byteStringMicro);
    }
}
