package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$MutualMarkSetting extends MessageMicro<mutualmark$MutualMarkSetting> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField close_friend = PBField.initBool(false);
    public final PBBoolField close_game = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"close_friend", "close_game"}, new Object[]{bool, bool}, mutualmark$MutualMarkSetting.class);
    }
}
