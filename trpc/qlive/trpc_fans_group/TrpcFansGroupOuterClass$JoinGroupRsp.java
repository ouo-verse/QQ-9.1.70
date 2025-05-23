package trpc.qlive.trpc_fans_group;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.bussiness.accountlevel.report.ProfileVipReport;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrpcFansGroupOuterClass$JoinGroupRsp extends MessageMicro<TrpcFansGroupOuterClass$JoinGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"retcode", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, ProfileVipReport.LEVEL_MODULE_ID, "group_info"}, new Object[]{0, "", null, null}, TrpcFansGroupOuterClass$JoinGroupRsp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public TrpcFansGroupOuterClass$LevelInfo level_info = new TrpcFansGroupOuterClass$LevelInfo();
    public TrpcFansGroupOuterClass$FansGroupInfo group_info = new TrpcFansGroupOuterClass$FansGroupInfo();
}
