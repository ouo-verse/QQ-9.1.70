package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe26$EntranceTemplate extends MessageMicro<oidb_0xe26$EntranceTemplate> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_custom_url;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_url;
    public final PBUInt32Field end_time;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435994id = PBField.initUInt32(0);
    public final PBBytesField name;
    public final PBUInt32Field start_time;
    public final PBUInt32Field state;
    public final PBBytesField template_text;
    public final PBStringField trace_info;
    public final PBUInt32Field type;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 66, 74, 82, 90}, new String[]{"id", "name", "state", "template_text", "start_time", "end_time", "type", "bytes_url", "bytes_icon_url", "bytes_icon_custom_url", "trace_info"}, new Object[]{0, byteStringMicro, 0, byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, ""}, oidb_0xe26$EntranceTemplate.class);
    }

    public oidb_0xe26$EntranceTemplate() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.name = PBField.initBytes(byteStringMicro);
        this.state = PBField.initUInt32(0);
        this.template_text = PBField.initBytes(byteStringMicro);
        this.start_time = PBField.initUInt32(0);
        this.end_time = PBField.initUInt32(0);
        this.type = PBField.initUInt32(0);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_custom_url = PBField.initBytes(byteStringMicro);
        this.trace_info = PBField.initString("");
    }
}
