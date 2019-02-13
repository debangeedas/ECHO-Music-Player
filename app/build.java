public class build extends groovy.lang.Script {
    public static void main(java.lang.String[] args) {
        new build(new groovy.lang.Binding(args)).run();
    }

    public java.lang.Object run() {
        java.util.LinkedHashMap<java.lang.String, java.lang.String> map = new java.util.LinkedHashMap<java.lang.String, java.lang.String>(1);
        map.put("plugin", "com.android.application");
        apply(map);

        java.util.LinkedHashMap<java.lang.String, java.lang.String> map1 = new java.util.LinkedHashMap<java.lang.String, java.lang.String>(1);
        map1.put("plugin", "kotlin-android");
        apply(map1);

        java.util.LinkedHashMap<java.lang.String, java.lang.String> map2 = new java.util.LinkedHashMap<java.lang.String, java.lang.String>(1);
        map2.put("plugin", "kotlin-android-extensions");
        apply(map2);

        android(new groovy.lang.Closure<java.lang.Object>(this, this) {
            public java.lang.Object doCall(java.lang.Object it) {
                compileSdkVersion(new java.lang.Object[]{28});
                defaultConfig(new groovy.lang.Closure<java.lang.Object>(build.this, build.this) {
                    public java.lang.Object doCall(java.lang.Object it) {
                        getApplicationId();
                        minSdkVersion(15);
                        targetSdkVersion(28);
                        getVersionCode();
                        getVersionName();
                        return getTestInstrumentationRunner();
                    }

                    public java.lang.Object doCall() {
                        return doCall(null);
                    }

                });
                return buildTypes(new java.lang.Object[]{new groovy.lang.Closure<com.android.build.gradle.internal.dsl.BuildType>(build.this, build.this) {
                    public com.android.build.gradle.internal.dsl.BuildType doCall(java.lang.Object it) {
                        return release(new groovy.lang.Closure<com.android.build.gradle.internal.dsl.BuildType>(build.this, build.this) {
                            public com.android.build.gradle.internal.dsl.BuildType doCall(java.lang.Object it) {
                                isMinifyEnabled();
                                return proguardFiles(invokeMethod("getDefaultProguardFile", new java.lang.Object[]{"proguard-android.txt"}), "proguard-rules.pro");
                            }

                            public BuildType doCall() {
                                return doCall(null);
                            }

                        });
                    }

                    public BuildType doCall() {
                        return doCall(null);
                    }

                }});
            }

            public java.lang.Object doCall() {
                return doCall(null);
            }

        });

        dependencies(new groovy.lang.Closure<org.gradle.api.artifacts.Dependency>(this, this) {
            public org.gradle.api.artifacts.Dependency doCall(java.lang.Object it) {
                implementation(new java.lang.Object[]{"com.cleveroad:audiovisualization:1.0.0"});
                java.util.LinkedHashMap<java.lang.String, java.lang.Object> map3 = new java.util.LinkedHashMap<java.lang.String, java.lang.Object>(2);
                map3.put("dir", "libs");
                map3.put("include", new java.util.ArrayList<java.lang.String>(java.util.Arrays.asList("*.jar")));
                implementation(new java.lang.Object[]{fileTree(map3)});
                implementation(new java.lang.Object[]{"org.jetbrains.kotlin:kotlin-stdlib-jdk7:" + build.this.getBinding().getProperty("kotlin_version")});
                implementation(new java.lang.Object[]{"com.android.support:appcompat-v7:28.0.0-alpha3"});
                implementation(new java.lang.Object[]{"com.android.support:design:28.0.0-alpha3"});
                implementation(new java.lang.Object[]{"com.android.support.constraint:constraint-layout:1.1.2"});
                implementation(new java.lang.Object[]{"com.android.support:support-v4:28.0.0-alpha3"});
                testImplementation(new java.lang.Object[]{"junit:junit:4.12"});
                androidTestImplementation(new java.lang.Object[]{"com.android.support.test:runner:1.0.2"});
                return androidTestImplementation(new java.lang.Object[]{"com.android.support.test.espresso:espresso-core:3.0.2"});
            }

            public Dependency doCall() {
                return doCall(null);
            }

        });
        return null;

    }

    public build(Binding binding) {
        super(binding);
    }

    public build() {
        super();
    }
}
