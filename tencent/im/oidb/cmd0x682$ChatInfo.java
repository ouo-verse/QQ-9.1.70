package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x682$ChatInfo extends MessageMicro<cmd0x682$ChatInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField express_msg;
    public final PBBytesField express_tips_msg;
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_chatflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_goldflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totalexpcount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_curexpcount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_totalFlag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_curdayFlag = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 74}, new String[]{"uint64_touin", "uint32_chatflag", "uint32_goldflag", "uint32_totalexpcount", "uint32_curexpcount", "uint32_totalFlag", "uint32_curdayFlag", "express_tips_msg", "express_msg"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro}, cmd0x682$ChatInfo.class);
    }

    public cmd0x682$ChatInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.express_tips_msg = PBField.initBytes(byteStringMicro);
        this.express_msg = PBField.initBytes(byteStringMicro);
    }
}
