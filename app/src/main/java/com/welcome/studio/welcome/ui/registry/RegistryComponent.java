package com.welcome.studio.welcome.ui.registry;

import com.welcome.studio.welcome.ui.registry.choose_screen.ChooseFragment;
import com.welcome.studio.welcome.ui.registry.singup.first_screen.SignUp;
import com.welcome.studio.welcome.ui.registry.singup.last_screen.NextStep;

import dagger.Subcomponent;

/**
 * Created by Royal on 06.01.2017.
 */
@RegistryScope
@Subcomponent(modules = {RegistryModule.class})
public interface RegistryComponent {
    void inject(SignUp signUp);
    void inject(Registry registry);
    void inject(ChooseFragment chooseFragment);
    void inject(NextStep nextStep);
}
