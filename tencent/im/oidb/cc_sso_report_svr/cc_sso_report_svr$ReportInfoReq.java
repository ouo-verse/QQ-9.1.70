package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cc_sso_report_svr$ReportInfoReq extends MessageMicro<cc_sso_report_svr$ReportInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"basic_info", "video_info", "play_info", "ext_info"}, new Object[]{null, null, null, null}, cc_sso_report_svr$ReportInfoReq.class);
    public cc_sso_report_svr$BasicInfo basic_info = new MessageMicro<cc_sso_report_svr$BasicInfo>() { // from class: tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr$BasicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{WadlProxyConsts.CHANNEL, "platform", "version"}, new Object[]{0, 0, ""}, cc_sso_report_svr$BasicInfo.class);
        public final PBUInt32Field channel = PBField.initUInt32(0);
        public final PBUInt32Field platform = PBField.initUInt32(0);
        public final PBStringField version = PBField.initString("");
    };
    public cc_sso_report_svr$VideoInfo video_info = new MessageMicro<cc_sso_report_svr$VideoInfo>() { // from class: tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr$VideoInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"busitype", "video_type", "file_size", "video_duration", "encode_type", "weight", "height", "rate"}, new Object[]{0, 0, 0L, 0L, 0, 0L, 0L, ""}, cc_sso_report_svr$VideoInfo.class);
        public final PBUInt32Field busitype = PBField.initUInt32(0);
        public final PBUInt32Field video_type = PBField.initUInt32(0);
        public final PBUInt64Field file_size = PBField.initUInt64(0);
        public final PBUInt64Field video_duration = PBField.initUInt64(0);
        public final PBUInt32Field encode_type = PBField.initUInt32(0);
        public final PBUInt64Field weight = PBField.initUInt64(0);
        public final PBUInt64Field height = PBField.initUInt64(0);
        public final PBStringField rate = PBField.initString("");
    };
    public cc_sso_report_svr$PlayInfo play_info = new MessageMicro<cc_sso_report_svr$PlayInfo>() { // from class: tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr$PlayInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"genurl_duration", "genurl_errcode", "prepare_duration", "play_duration", "play_errcode", "skipframe_cnt"}, new Object[]{0L, 0, 0L, 0L, "", 0}, cc_sso_report_svr$PlayInfo.class);
        public final PBUInt64Field genurl_duration = PBField.initUInt64(0);
        public final PBUInt32Field genurl_errcode = PBField.initUInt32(0);
        public final PBUInt64Field prepare_duration = PBField.initUInt64(0);
        public final PBUInt64Field play_duration = PBField.initUInt64(0);
        public final PBStringField play_errcode = PBField.initString("");
        public final PBUInt32Field skipframe_cnt = PBField.initUInt32(0);
    };
    public final PBRepeatMessageField<cc_sso_report_svr$KeyVal> ext_info = PBField.initRepeatMessage(cc_sso_report_svr$KeyVal.class);
}
