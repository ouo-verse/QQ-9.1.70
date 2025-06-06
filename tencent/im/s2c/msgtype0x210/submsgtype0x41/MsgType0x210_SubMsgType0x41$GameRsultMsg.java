package tencent.im.s2c.msgtype0x210.submsgtype0x41;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgType0x210_SubMsgType0x41$GameRsultMsg extends MessageMicro<MsgType0x210_SubMsgType0x41$GameRsultMsg> {
    public static final int BYTES_NICKNAME_FIELD_NUMBER = 7;
    public static final int RPT_MSG_GAME_RSTS_FIELD_NUMBER = 4;
    public static final int STR_GAME_NAME_FIELD_NUMBER = 1;
    public static final int STR_GAME_PIC_FIELD_NUMBER = 2;
    public static final int STR_GAME_SUBHEADING_FIELD_NUMBER = 5;
    public static final int STR_MORE_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"str_game_name", "str_game_pic", "str_more_info", "rpt_msg_game_rsts", "str_game_subheading", "uint64_uin", "bytes_nickname"}, new Object[]{"", "", "", null, "", 0L, ByteStringMicro.EMPTY}, MsgType0x210_SubMsgType0x41$GameRsultMsg.class);
    public final PBStringField str_game_name = PBField.initString("");
    public final PBStringField str_game_pic = PBField.initString("");
    public final PBStringField str_more_info = PBField.initString("");
    public final PBRepeatMessageField<MsgType0x210_SubMsgType0x41$UinResult> rpt_msg_game_rsts = PBField.initRepeatMessage(MsgType0x210_SubMsgType0x41$UinResult.class);
    public final PBStringField str_game_subheading = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
}
