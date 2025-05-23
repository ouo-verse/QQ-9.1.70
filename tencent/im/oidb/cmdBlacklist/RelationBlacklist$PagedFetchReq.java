package tencent.im.oidb.cmdBlacklist;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class RelationBlacklist$PagedFetchReq extends MessageMicro<RelationBlacklist$PagedFetchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"seq", "start", WidgetCacheConstellationData.NUM}, new Object[]{0L, 0L, 0L}, RelationBlacklist$PagedFetchReq.class);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt64Field start = PBField.initUInt64(0);
    public final PBUInt64Field num = PBField.initUInt64(0);
}
