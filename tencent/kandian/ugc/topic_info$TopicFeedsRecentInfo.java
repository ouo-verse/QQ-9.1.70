package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class topic_info$TopicFeedsRecentInfo extends MessageMicro<topic_info$TopicFeedsRecentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"topic_id", "rowkey_info", "module_type"}, new Object[]{0, null, 0}, topic_info$TopicFeedsRecentInfo.class);
    public final PBUInt32Field topic_id = PBField.initUInt32(0);
    public topic_info$RowkeyInfo rowkey_info = new MessageMicro<topic_info$RowkeyInfo>() { // from class: tencent.kandian.ugc.topic_info$RowkeyInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 74}, new String[]{"add_time", "rowkey", "start_ts", "end_ts", "content_type", DefaultTVKDataProvider.KEY_PAY_TYPE, "weight", "chapter", "show_text"}, new Object[]{0L, "", 0, 0, 0, 0, 0, 0, ""}, topic_info$RowkeyInfo.class);
        public final PBUInt64Field add_time = PBField.initUInt64(0);
        public final PBStringField rowkey = PBField.initString("");
        public final PBUInt32Field start_ts = PBField.initUInt32(0);
        public final PBUInt32Field end_ts = PBField.initUInt32(0);
        public final PBUInt32Field content_type = PBField.initUInt32(0);
        public final PBUInt32Field pay_type = PBField.initUInt32(0);
        public final PBUInt32Field weight = PBField.initUInt32(0);
        public final PBUInt32Field chapter = PBField.initUInt32(0);
        public final PBStringField show_text = PBField.initString("");
    };
    public final PBUInt32Field module_type = PBField.initUInt32(0);
}
