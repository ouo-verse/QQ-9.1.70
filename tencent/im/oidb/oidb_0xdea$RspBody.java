package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdea$RspBody extends MessageMicro<oidb_0xdea$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"add_barrage_rsp", "get_barrage_list_rsp", "rpt_recall_barrage_rsp_list", "rpt_delete_barrage_rsp_list", "get_topic_rsp", "get_comment_rsp"}, new Object[]{null, null, null, null, null, null}, oidb_0xdea$RspBody.class);
    public oidb_0xdea$AddBarrageRspBody add_barrage_rsp = new MessageMicro<oidb_0xdea$AddBarrageRspBody>() { // from class: tencent.im.oidb.oidb_0xdea$AddBarrageRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret_code", "str_err_msg", "str_wording"}, new Object[]{0, "", ""}, oidb_0xdea$AddBarrageRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBStringField str_wording = PBField.initString("");
    };
    public oidb_0xdea$GetBarrageListRspBody get_barrage_list_rsp = new MessageMicro<oidb_0xdea$GetBarrageListRspBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetBarrageListRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 56, 66, 72, 88, 96}, new String[]{"int32_ret_code", "str_err_msg", "str_wording", "bool_is_end", "uint32_total_count", "uint32_next_start_index", "rpt_comment_list", "rpt_recall_del_seq_list", "uint32_last_update_time", "uint32_time_interval"}, new Object[]{0, "", "", Boolean.FALSE, 0, 0, null, 0L, 0, 0}, oidb_0xdea$GetBarrageListRspBody.class);
        public final PBInt32Field int32_ret_code = PBField.initInt32(0);
        public final PBStringField str_err_msg = PBField.initString("");
        public final PBStringField str_wording = PBField.initString("");
        public final PBBoolField bool_is_end = PBField.initBool(false);
        public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_start_index = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0xdea$Comment> rpt_comment_list = PBField.initRepeatMessage(oidb_0xdea$Comment.class);
        public final PBRepeatField<Long> rpt_recall_del_seq_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<oidb_0xdea$RecallBarrageRspBody> rpt_recall_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea$RecallBarrageRspBody.class);
    public final PBRepeatMessageField<oidb_0xdea$DeleteBarrageRspBody> rpt_delete_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea$DeleteBarrageRspBody.class);
    public oidb_0xdea$GetTopicRspBody get_topic_rsp = new MessageMicro<oidb_0xdea$GetTopicRspBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetTopicRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetTopicRspBody.class);
    };
    public oidb_0xdea$GetCommentRspBody get_comment_rsp = new MessageMicro<oidb_0xdea$GetCommentRspBody>() { // from class: tencent.im.oidb.oidb_0xdea$GetCommentRspBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xdea$GetCommentRspBody.class);
    };
}
