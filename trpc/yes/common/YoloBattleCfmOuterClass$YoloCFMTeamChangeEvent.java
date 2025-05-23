package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCfmOuterClass$YoloCFMTeamChangeEvent extends MessageMicro<YoloBattleCfmOuterClass$YoloCFMTeamChangeEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"event", "cfm_schema"}, new Object[]{null, null}, YoloBattleCfmOuterClass$YoloCFMTeamChangeEvent.class);
    public CfmDataOuterClass$CFMStatusChangeEvent event = new CfmDataOuterClass$CFMStatusChangeEvent();
    public YoloBattleCfmOuterClass$YoloCFMSchema cfm_schema = new YoloBattleCfmOuterClass$YoloCFMSchema();
}
