package qzonemoment;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentCommon$StCommonExt extends MessageMicro<QZMomentCommon$StCommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{ThirdPartyMiniApiImpl.KEY_MAP_INFO, "attachInfo", "mapBytesInfo"}, new Object[]{null, "", null}, QZMomentCommon$StCommonExt.class);
    public final PBRepeatMessageField<QZMomentCommon$Entry> mapInfo = PBField.initRepeatMessage(QZMomentCommon$Entry.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<QZMomentCommon$BytesEntry> mapBytesInfo = PBField.initRepeatMessage(QZMomentCommon$BytesEntry.class);
}
