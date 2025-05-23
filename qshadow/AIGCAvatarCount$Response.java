package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AIGCAvatarCount$Response extends MessageMicro<AIGCAvatarCount$Response> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret_code", "ret_msg", "select_quota_rsp", "reduce_quota_rsp", "privilege_rsp"}, new Object[]{0, "", null, null, null}, AIGCAvatarCount$Response.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public SelectQuotaRsp select_quota_rsp = new SelectQuotaRsp();
    public ReduceQuotaRsp reduce_quota_rsp = new ReduceQuotaRsp();
    public PrivilegeRsp privilege_rsp = new PrivilegeRsp();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PrivilegeRsp extends MessageMicro<PrivilegeRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"svip_quota_total"}, new Object[]{0}, PrivilegeRsp.class);
        public final PBUInt32Field svip_quota_total = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReduceQuotaRsp extends MessageMicro<ReduceQuotaRsp> {
        public static final int QUOTA_TYPE_FREE = 1;
        public static final int QUOTA_TYPE_SVIP = 2;
        public static final int QUOTA_TYPE_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"quota_infos", "extra_info"}, new Object[]{null, null}, ReduceQuotaRsp.class);
        public final PBRepeatMessageField<QuotaInfo> quota_infos = PBField.initRepeatMessage(QuotaInfo.class);
        public ExtraInfo extra_info = new ExtraInfo();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ExtraInfo extends MessageMicro<ExtraInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"svip_level"}, new Object[]{0}, ExtraInfo.class);
            public final PBUInt32Field svip_level = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QuotaDetail extends MessageMicro<QuotaDetail> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"total_quota", "used_quota", "remain_quota"}, new Object[]{0, 0, 0}, QuotaDetail.class);
            public final PBUInt32Field total_quota = PBField.initUInt32(0);
            public final PBUInt32Field used_quota = PBField.initUInt32(0);
            public final PBUInt32Field remain_quota = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QuotaInfo extends MessageMicro<QuotaInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"quota_type", "quota_detail"}, new Object[]{0, null}, QuotaInfo.class);
            public final PBEnumField quota_type = PBField.initEnum(0);
            public QuotaDetail quota_detail = new QuotaDetail();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SelectQuotaRsp extends MessageMicro<SelectQuotaRsp> {
        public static final int QUOTA_TYPE_FREE = 1;
        public static final int QUOTA_TYPE_SVIP = 2;
        public static final int QUOTA_TYPE_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"quota_infos", "extra_info"}, new Object[]{null, null}, SelectQuotaRsp.class);
        public final PBRepeatMessageField<QuotaInfo> quota_infos = PBField.initRepeatMessage(QuotaInfo.class);
        public ExtraInfo extra_info = new ExtraInfo();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ExtraInfo extends MessageMicro<ExtraInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"svip_level"}, new Object[]{0}, ExtraInfo.class);
            public final PBUInt32Field svip_level = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QuotaDetail extends MessageMicro<QuotaDetail> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"total_quota", "used_quota", "remain_quota"}, new Object[]{0, 0, 0}, QuotaDetail.class);
            public final PBUInt32Field total_quota = PBField.initUInt32(0);
            public final PBUInt32Field used_quota = PBField.initUInt32(0);
            public final PBUInt32Field remain_quota = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QuotaInfo extends MessageMicro<QuotaInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"quota_type", "quota_detail"}, new Object[]{0, null}, QuotaInfo.class);
            public final PBEnumField quota_type = PBField.initEnum(0);
            public QuotaDetail quota_detail = new QuotaDetail();
        }
    }
}
