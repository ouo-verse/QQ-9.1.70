package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype9 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype9> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_anchor_head_url;
    public final PBBytesField bytes_jump_schema;
    public final PBStringField str_anchor_nickname;
    public final PBStringField str_live_title;
    public final PBUInt32Field uint32_anchor_status = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_anchor_status", "bytes_jump_schema", "str_anchor_nickname", "bytes_anchor_head_url", "str_live_title"}, new Object[]{0, byteStringMicro, "", byteStringMicro, ""}, hummer_commelem$MsgElemInfo_servtype9.class);
    }

    public hummer_commelem$MsgElemInfo_servtype9() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_jump_schema = PBField.initBytes(byteStringMicro);
        this.str_anchor_nickname = PBField.initString("");
        this.bytes_anchor_head_url = PBField.initBytes(byteStringMicro);
        this.str_live_title = PBField.initString("");
    }
}
