package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tenpay.sdk.util.QWSoterConstans;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AIGCAvatarCount$Request extends MessageMicro<AIGCAvatarCount$Request> {
    public static final int CMD_PRIVILEGE = 300;
    public static final int CMD_REDUCE = 200;
    public static final int CMD_SELECT = 100;
    public static final int CMD_UNKNOWN = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"cmd", "select_quota_req", "reduce_quota_req", "privilege_req"}, new Object[]{0, null, null, null}, AIGCAvatarCount$Request.class);
    public final PBEnumField cmd = PBField.initEnum(0);
    public SelectQuotaReq select_quota_req = new SelectQuotaReq();
    public ReduceQuotaReq reduce_quota_req = new ReduceQuotaReq();
    public PrivilegeReq privilege_req = new PrivilegeReq();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PrivilegeReq extends MessageMicro<PrivilegeReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"scenes"}, new Object[]{""}, PrivilegeReq.class);
        public final PBStringField scenes = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReduceQuotaReq extends MessageMicro<ReduceQuotaReq> {
        public static final int BUSI_TYPE_QQBASE = 1;
        public static final int BUSI_TYPE_SMALL_CIRCLE = 2;
        public static final int BUSI_TYPE_UNKNOWN = 0;
        public static final int QUOTA_TYPE_FREE = 1;
        public static final int QUOTA_TYPE_SVIP = 2;
        public static final int QUOTA_TYPE_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "quota_type", "reduce_num", "random_seq"}, new Object[]{0, 0, 0, 0}, ReduceQuotaReq.class);
        public final PBEnumField busi_type = PBField.initEnum(0);
        public final PBEnumField quota_type = PBField.initEnum(0);
        public final PBUInt32Field reduce_num = PBField.initUInt32(0);
        public final PBUInt32Field random_seq = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SelectQuotaReq extends MessageMicro<SelectQuotaReq> {
        public static final int BUSI_TYPE_QQBASE = 1;
        public static final int BUSI_TYPE_SMALL_CIRCLE = 2;
        public static final int BUSI_TYPE_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE}, new Object[]{0}, SelectQuotaReq.class);
        public final PBEnumField busi_type = PBField.initEnum(0);
    }
}
