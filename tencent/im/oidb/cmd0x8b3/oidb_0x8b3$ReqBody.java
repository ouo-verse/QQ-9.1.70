package tencent.im.oidb.cmd0x8b3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b3$ReqBody extends MessageMicro<oidb_0x8b3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_hot_group_id", "st_group_info"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x8b3$ReqBody.class);
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x8b3$groupinfo st_group_info = new MessageMicro<oidb_0x8b3$groupinfo>() { // from class: tencent.im.oidb.cmd0x8b3.oidb_0x8b3$groupinfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField string_group_memo;
        public final PBBytesField string_jumping_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_group_memo", "string_jumping_url"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x8b3$groupinfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.string_group_memo = PBField.initBytes(byteStringMicro);
            this.string_jumping_url = PBField.initBytes(byteStringMicro);
        }
    };
}
