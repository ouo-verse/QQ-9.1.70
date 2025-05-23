package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfa4$MsgBoardInfo extends MessageMicro<oidb_cmd0xfa4$MsgBoardInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon;

    /* renamed from: id, reason: collision with root package name */
    public oidb_cmd0xfa4$SourceInfo f436000id = new oidb_cmd0xfa4$SourceInfo();
    public final PBBoolField is_red;
    public final PBUInt64Field time_stamp;
    public final PBBytesField title;
    public final PBBytesField url;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"id", "title", "icon", "url", "time_stamp", "is_red"}, new Object[]{null, byteStringMicro, byteStringMicro, byteStringMicro, 0L, Boolean.FALSE}, oidb_cmd0xfa4$MsgBoardInfo.class);
    }

    public oidb_cmd0xfa4$MsgBoardInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.title = PBField.initBytes(byteStringMicro);
        this.icon = PBField.initBytes(byteStringMicro);
        this.url = PBField.initBytes(byteStringMicro);
        this.time_stamp = PBField.initUInt64(0L);
        this.is_red = PBField.initBool(false);
    }
}
