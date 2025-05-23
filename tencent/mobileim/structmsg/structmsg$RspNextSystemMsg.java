package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$RspNextSystemMsg extends MessageMicro<structmsg$RspNextSystemMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 802, 810, 816}, new String[]{"head", "msgs", "following_friend_seq", "following_group_seq", "checktype", "bytes_game_nick", "bytes_undecid_for_qim", "uint32_un_read_count3"}, new Object[]{null, null, 0L, 0L, 1, "", ByteStringMicro.EMPTY, 0}, structmsg$RspNextSystemMsg.class);
    public structmsg$RspHead head = new structmsg$RspHead();
    public final PBRepeatMessageField<structmsg$StructMsg> msgs = PBField.initRepeatMessage(structmsg$StructMsg.class);
    public final PBUInt64Field following_friend_seq = PBField.initUInt64(0);
    public final PBUInt64Field following_group_seq = PBField.initUInt64(0);
    public final PBEnumField checktype = PBField.initEnum(1);
    public final PBStringField bytes_game_nick = PBField.initString("");
    public final PBBytesField bytes_undecid_for_qim = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_un_read_count3 = PBField.initUInt32(0);
}
