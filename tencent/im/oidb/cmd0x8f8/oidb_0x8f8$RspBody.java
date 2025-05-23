package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.feeds_inner_define.feeds_inner_define$FaceRecordSet;
import com.trunk.group_feeds.group_feeds$GroupFeedsMessage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f8$RspBody extends MessageMicro<oidb_0x8f8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114}, new String[]{"msg_source_id", "msg_result", "msg_add_feeds_rsp", "msg_add_cmmnt_rsp", "msg_add_face_rsp", "msg_del_feeds_rsp", "msg_del_cmmnt_rsp", "msg_set_feeds_flag_rsp", "msg_add_visit_rsp", "msg_attend_vote_rsp", "msg_del_apic_rsp", "msg_set_theme_rsp", "msg_set_asyncmsg_state_rsp", "msg_del_litemail_index_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x8f8$RspBody.class);
    public oidb_0x8f8$SourceID msg_source_id = new oidb_0x8f8$SourceID();
    public oidb_0x8f8$ResultMsg msg_result = new MessageMicro<oidb_0x8f8$ResultMsg>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$ResultMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x8f8$ResultMsg.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f8$SubCmd01AddFeedsRsp msg_add_feeds_rsp = new MessageMicro<oidb_0x8f8$SubCmd01AddFeedsRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd01AddFeedsRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_feeds_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8f8$SubCmd01AddFeedsRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f8$SubCmd02AddCmmntRsp msg_add_cmmnt_rsp = new MessageMicro<oidb_0x8f8$SubCmd02AddCmmntRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd02AddCmmntRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "uint32_cmmnt_id", "uint32_cmmnt_count"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f8$SubCmd02AddCmmntRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cmmnt_count = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd04AddFaceRsp msg_add_face_rsp = new MessageMicro<oidb_0x8f8$SubCmd04AddFaceRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd04AddFaceRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_feeds_id", "msg_face_set"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x8f8$SubCmd04AddFaceRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public feeds_inner_define$FaceRecordSet msg_face_set = new feeds_inner_define$FaceRecordSet();
    };
    public oidb_0x8f8$SubCmd05DelFeedsRsp msg_del_feeds_rsp = new MessageMicro<oidb_0x8f8$SubCmd05DelFeedsRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd05DelFeedsRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_feeds_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x8f8$SubCmd05DelFeedsRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x8f8$SubCmd06DelCmmntRsp msg_del_cmmnt_rsp = new MessageMicro<oidb_0x8f8$SubCmd06DelCmmntRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd06DelCmmntRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_cmmnt_id"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd06DelCmmntRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_cmmnt_id = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd07SetFeedsFlagRsp msg_set_feeds_flag_rsp = new MessageMicro<oidb_0x8f8$SubCmd07SetFeedsFlagRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd07SetFeedsFlagRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"bytes_feeds_id", "uint32_flag", "uint32_theme_state"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x8f8$SubCmd07SetFeedsFlagRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd09AddVisitRsp msg_add_visit_rsp = new MessageMicro<oidb_0x8f8$SubCmd09AddVisitRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd09AddVisitRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_visit_num"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd09AddVisitRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_visit_num = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd16AttendVoteRsp msg_attend_vote_rsp = new MessageMicro<oidb_0x8f8$SubCmd16AttendVoteRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd16AttendVoteRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 114, 122}, new String[]{"bytes_feeds_id", "rpt_uint32_voteids", "rpt_vote_statistic", "rpt_vote_record"}, new Object[]{ByteStringMicro.EMPTY, 0, null, null}, oidb_0x8f8$SubCmd16AttendVoteRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<Integer> rpt_uint32_voteids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBRepeatMessageField<group_feeds$GroupFeedsMessage.VoteStatistic> rpt_vote_statistic = PBField.initRepeatMessage(group_feeds$GroupFeedsMessage.VoteStatistic.class);
        public final PBRepeatMessageField<group_feeds$GroupFeedsMessage.VoteRecord> rpt_vote_record = PBField.initRepeatMessage(group_feeds$GroupFeedsMessage.VoteRecord.class);
    };
    public oidb_0x8f8$SubCmd17DelAPicUrlRsp msg_del_apic_rsp = new MessageMicro<oidb_0x8f8$SubCmd17DelAPicUrlRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd17DelAPicUrlRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_feeds_id;
        public final PBBytesField bytes_pic_url;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_feeds_id", "bytes_pic_url"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x8f8$SubCmd17DelAPicUrlRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_feeds_id = PBField.initBytes(byteStringMicro);
            this.bytes_pic_url = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x8f8$SubCmd18SetThemeStateRsp msg_set_theme_rsp = new MessageMicro<oidb_0x8f8$SubCmd18SetThemeStateRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd18SetThemeStateRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_feeds_id", "uint32_theme_state"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0x8f8$SubCmd18SetThemeStateRsp.class);
        public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_theme_state = PBField.initUInt32(0);
    };
    public oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp msg_set_asyncmsg_state_rsp = new MessageMicro<oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatField<ByteStringMicro> rpt_bytes_fail_feeds_id;
        public final PBRepeatField<ByteStringMicro> rpt_bytes_success_feeds_id;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_bytes_success_feeds_id", "rpt_bytes_fail_feeds_id"}, new Object[]{byteStringMicro, byteStringMicro}, oidb_0x8f8$SubCmd19SetAsyncMsgStateRsp.class);
        }

        {
            PBBytesField pBBytesField = PBBytesField.__repeatHelper__;
            this.rpt_bytes_success_feeds_id = PBField.initRepeat(pBBytesField);
            this.rpt_bytes_fail_feeds_id = PBField.initRepeat(pBBytesField);
        }
    };
    public oidb_0x8f8$SubCmd20DelLiteMailIndexRsp msg_del_litemail_index_rsp = new MessageMicro<oidb_0x8f8$SubCmd20DelLiteMailIndexRsp>() { // from class: tencent.im.oidb.cmd0x8f8.oidb_0x8f8$SubCmd20DelLiteMailIndexRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_succ_lite_mail_index", "rpt_msg_fail_lite_mail_index"}, new Object[]{null, null}, oidb_0x8f8$SubCmd20DelLiteMailIndexRsp.class);
        public final PBRepeatMessageField<oidb_0x8f8$LiteMailIndexInfo> rpt_msg_succ_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8$LiteMailIndexInfo.class);
        public final PBRepeatMessageField<oidb_0x8f8$LiteMailIndexInfo> rpt_msg_fail_lite_mail_index = PBField.initRepeatMessage(oidb_0x8f8$LiteMailIndexInfo.class);
    };
}
