package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.group_feeds.group_feeds$GroupFeedsMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f8$ReqBody extends MessageMicro<oidb_0x8f8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106}, new String[]{"msg_source_id", "msg_add_feeds", "msg_add_cmmnt", "msg_add_face", "msg_del_feeds", "msg_del_cmmnt", "msg_set_feeds_flag", "msg_add_visit", "msg_attend_vote", "msg_del_apic", "msg_set_theme", "msg_set_async_state", "msg_del_litemail_index"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x8f8$ReqBody.class);
    public oidb_0x8f8$SourceID msg_source_id = new oidb_0x8f8$SourceID();
    public oidb_0x8f8$SubCmd01AddFeedsReq msg_add_feeds = new MessageMicro<oidb_0x8f8$SubCmd01AddFeedsReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd01AddFeedsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint32_feeds_type", "msg_feeds", "uint32_auto_pull_flag", "uint32_msg_type"}, new Object[]{0, null, 0, 0}, oidb_0x8f8$SubCmd01AddFeedsReq.class);
        public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
        public group_feeds$GroupFeedsMessage msg_feeds = new group_feeds$GroupFeedsMessage();
        public final PBUInt32Field uint32_auto_pull_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd02AddCmmntReq msg_add_cmmnt = new MessageMicro<oidb_0x8f8$SubCmd02AddCmmntReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd02AddCmmntReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"bytes_feeds_id", "msg_comment", "uint32_cmmnt_id", "rpt_concern_uin"}, new Object[]{ByteStringMicro.EMPTY, null, 0, 0L}, oidb_0x8f8$SubCmd02AddCmmntReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public group_feeds$GroupFeedsMessage msg_comment = new group_feeds$GroupFeedsMessage();
        public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
        public final PBRepeatField<Long> rpt_concern_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public oidb_0x8f8$SubCmd04AddFaceReq msg_add_face = new MessageMicro<oidb_0x8f8$SubCmd04AddFaceReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd04AddFaceReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_face_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd04AddFaceReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd05DelFeedsReq msg_del_feeds = new MessageMicro<oidb_0x8f8$SubCmd05DelFeedsReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd05DelFeedsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "uint32_del_type", "uint32_edu_id"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f8$SubCmd05DelFeedsReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_del_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_edu_id = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd06DelCmmntReq msg_del_cmmnt = new MessageMicro<oidb_0x8f8$SubCmd06DelCmmntReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd06DelCmmntReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_cmmnt_id"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd06DelCmmntReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd07SetFeedsFlagReq msg_set_feeds_flag = new MessageMicro<oidb_0x8f8$SubCmd07SetFeedsFlagReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd07SetFeedsFlagReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "uint32_flag", "uint32_theme_state"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f8$SubCmd07SetFeedsFlagReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd09AddVisitReq msg_add_visit = new MessageMicro<oidb_0x8f8$SubCmd09AddVisitReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd09AddVisitReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_feeds_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8f8$SubCmd09AddVisitReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f8$SubCmd16AttendVoteReq msg_attend_vote = new MessageMicro<oidb_0x8f8$SubCmd16AttendVoteReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd16AttendVoteReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "rpt_uint32_voteids"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd16AttendVoteReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<Integer> rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    };
    public oidb_0x8f8$SubCmd17DelAPicUrlReq msg_del_apic = new MessageMicro<oidb_0x8f8$SubCmd17DelAPicUrlReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd17DelAPicUrlReq
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_feeds_id;
        public final PBBytesField bytes_pic_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_feeds_id", "bytes_pic_url"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x8f8$SubCmd17DelAPicUrlReq.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
            this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x8f8$SubCmd18SetThemeStateReq msg_set_theme = new MessageMicro<oidb_0x8f8$SubCmd18SetThemeStateReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd18SetThemeStateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_theme_state"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd18SetThemeStateReq.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd19SetAsyncMsgStateReq msg_set_async_state = new MessageMicro<oidb_0x8f8$SubCmd19SetAsyncMsgStateReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd19SetAsyncMsgStateReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_bytes_feeds_id", "uint32_set_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd19SetAsyncMsgStateReq.class);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd20DelLiteMailIndexReq msg_del_litemail_index = new MessageMicro<oidb_0x8f8$SubCmd20DelLiteMailIndexReq>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd20DelLiteMailIndexReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_lite_mail_index"}, new Object[]{null}, oidb_0x8f8$SubCmd20DelLiteMailIndexReq.class);
        public final PBRepeatMessageField<oidb_0x8f8$LiteMailIndexInfo> rpt_msg_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8$LiteMailIndexInfo.class);
    };
}
