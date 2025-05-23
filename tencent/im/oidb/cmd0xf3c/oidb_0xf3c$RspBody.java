package tencent.im.oidb.cmd0xf3c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf3c$RspBody extends MessageMicro<oidb_0xf3c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon;
    public final PBBytesField rank_entrance;
    public final PBBytesField rank_text;
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field active_num = PBField.initUInt64(0);
    public final PBUInt64Field rank_num = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50}, new String[]{"group_code", "active_num", "rank_num", "rank_entrance", "rank_text", "icon"}, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0xf3c$RspBody.class);
    }

    public oidb_0xf3c$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.rank_entrance = PBField.initBytes(byteStringMicro);
        this.rank_text = PBField.initBytes(byteStringMicro);
        this.icon = PBField.initBytes(byteStringMicro);
    }
}
