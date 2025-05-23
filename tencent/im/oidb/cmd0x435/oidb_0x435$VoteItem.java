package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x435$VoteItem extends MessageMicro<oidb_0x435$VoteItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_vote_id", "bytes_option_description", "uint32_vote_count", "uint32_user_define"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0}, oidb_0x435$VoteItem.class);
    public final PBUInt32Field uint32_vote_id = PBField.initUInt32(0);
    public final PBBytesField bytes_option_description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_vote_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_define = PBField.initUInt32(0);
}
