package tencent.trpcprotocol;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopMultiGroupManageSvr$DataItem extends MessageMicro<TroopMultiGroupManageSvr$DataItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{WidgetCacheConstellationData.NUM, "change"}, new Object[]{0, 0}, TroopMultiGroupManageSvr$DataItem.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBInt32Field change = PBField.initInt32(0);
}
