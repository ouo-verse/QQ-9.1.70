package tencent.im.msg.hummer.resv1;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TextMsgExtPb$ResvAttr extends MessageMicro<TextMsgExtPb$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 66}, new String[]{"wording", "text_analysis_result", "at_type", AppConstants.Key.KEY_AT_MEMBER_UIN, "at_member_tinyid", "at_member_role_info", "at_role_info", "at_channel_info"}, new Object[]{ByteStringMicro.EMPTY, 0, 0, 0L, 0L, null, null, null}, TextMsgExtPb$ResvAttr.class);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
    public final PBUInt32Field at_type = PBField.initUInt32(0);
    public final PBUInt64Field at_member_uin = PBField.initUInt64(0);
    public final PBUInt64Field at_member_tinyid = PBField.initUInt64(0);
    public TextMsgExtPb$RoleInfo at_member_role_info = new MessageMicro<TextMsgExtPb$RoleInfo>() { // from class: tencent.im.msg.hummer.resv1.TextMsgExtPb$RoleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, TextMsgExtPb$RoleInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt64Field f435950id = PBField.initUInt64(0);
        public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field flag = PBField.initUInt32(0);
    };
    public TextMsgExtPb$RoleInfo at_role_info = new MessageMicro<TextMsgExtPb$RoleInfo>() { // from class: tencent.im.msg.hummer.resv1.TextMsgExtPb$RoleInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "info", "flag"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, TextMsgExtPb$RoleInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt64Field f435950id = PBField.initUInt64(0);
        public final PBBytesField info = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field flag = PBField.initUInt32(0);
    };
    public TextMsgExtPb$ChannelInfo at_channel_info = new TextMsgExtPb$ChannelInfo();
}
